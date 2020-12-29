import { Component, Vue, Inject } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';

import DeviceService from '@/entities/device/device.service';
import { IDevice } from '@/shared/model/device.model';

import { IAudiofile, Audiofile } from '@/shared/model/audiofile.model';
import AudiofileService from './audiofile.service';

const validations: any = {
  audiofile: {
    artist: {
      required,
    },
    album: {},
    comment: {},
    genre: {},
    title: {
      required,
    },
    track: {},
    total: {},
    year: {},
    fieldname: {},
    bitrate: {},
    bitspersample: {},
    codec: {},
    covermimetype: {},
    coversize: {},
    covertype: {},
    coverheight: {},
    coverwidth: {},
    covers: {},
    lengthseconds: {},
    mode: {},
    samplerate: {},
    tool: {},
    vbr: {},
    directory: {},
    extension: {},
    filename: {},
    filenameext: {},
    filenamerel: {},
    folderpath: {},
    folderpathrel: {},
    parentdirectory: {},
    path: {},
    volume: {},
    workingdir: {},
    workingpath: {},
    filecreatedate: {},
    filemoddate: {},
    filesizebytes: {},
    crcVal: {},
    md5Val: {},
    md5audioVal: {},
    appVal: {},
  },
};

@Component({
  validations,
})
export default class AudiofileUpdate extends Vue {
  @Inject('audiofileService') private audiofileService: () => AudiofileService;
  public audiofile: IAudiofile = new Audiofile();

  @Inject('deviceService') private deviceService: () => DeviceService;

  public devices: IDevice[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.audiofileId) {
        vm.retrieveAudiofile(to.params.audiofileId);
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
    if (this.audiofile.id) {
      this.audiofileService()
        .update(this.audiofile)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('musicfilesApp.audiofile.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.audiofileService()
        .create(this.audiofile)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('musicfilesApp.audiofile.created', { param: param.id });
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

  public retrieveAudiofile(audiofileId): void {
    this.audiofileService()
      .find(audiofileId)
      .then(res => {
        this.audiofile = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.deviceService()
      .retrieve()
      .then(res => {
        this.devices = res.data;
      });
  }
}
