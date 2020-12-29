import { Component, Vue, Inject } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';

import AudiofileService from '@/entities/audiofile/audiofile.service';
import { IAudiofile } from '@/shared/model/audiofile.model';

import { IDevice, Device } from '@/shared/model/device.model';
import DeviceService from './device.service';

const validations: any = {
  device: {
    name: {
      required,
    },
  },
};

@Component({
  validations,
})
export default class DeviceUpdate extends Vue {
  @Inject('deviceService') private deviceService: () => DeviceService;
  public device: IDevice = new Device();

  @Inject('audiofileService') private audiofileService: () => AudiofileService;

  public audiofiles: IAudiofile[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.deviceId) {
        vm.retrieveDevice(to.params.deviceId);
      }
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.device.id) {
      this.deviceService()
        .update(this.device)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('musicfilesApp.device.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.deviceService()
        .create(this.device)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('musicfilesApp.device.created', { param: param.id });
          this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    }
  }

  public retrieveDevice(deviceId): void {
    this.deviceService()
      .find(deviceId)
      .then(res => {
        this.device = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.audiofileService()
      .retrieve()
      .then(res => {
        this.audiofiles = res.data;
      });
  }
}
