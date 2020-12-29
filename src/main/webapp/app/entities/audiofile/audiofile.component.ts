import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IAudiofile } from '@/shared/model/audiofile.model';

import AudiofileService from './audiofile.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Audiofile extends Vue {
  @Inject('audiofileService') private audiofileService: () => AudiofileService;
  private removeId: number = null;

  public audiofiles: IAudiofile[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllAudiofiles();
  }

  public clear(): void {
    this.retrieveAllAudiofiles();
  }

  public retrieveAllAudiofiles(): void {
    this.isFetching = true;

    this.audiofileService()
      .retrieve()
      .then(
        res => {
          this.audiofiles = res.data;
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

  public prepareRemove(instance: IAudiofile): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeAudiofile(): void {
    this.audiofileService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('musicfilesApp.audiofile.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllAudiofiles();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
