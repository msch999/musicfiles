import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IDevice } from '@/shared/model/device.model';

import DeviceService from './device.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Device extends Vue {
  @Inject('deviceService') private deviceService: () => DeviceService;
  private removeId: number = null;

  public devices: IDevice[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllDevices();
  }

  public clear(): void {
    this.retrieveAllDevices();
  }

  public retrieveAllDevices(): void {
    this.isFetching = true;

    this.deviceService()
      .retrieve()
      .then(
        res => {
          this.devices = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: IDevice): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeDevice(): void {
    this.deviceService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('musicfilesApp.device.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllDevices();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
