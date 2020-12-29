import { Component, Vue, Inject } from 'vue-property-decorator';

import { IAudiofile } from '@/shared/model/audiofile.model';
import AudiofileService from './audiofile.service';

@Component
export default class AudiofileDetails extends Vue {
  @Inject('audiofileService') private audiofileService: () => AudiofileService;
  public audiofile: IAudiofile = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.audiofileId) {
        vm.retrieveAudiofile(to.params.audiofileId);
      }
    });
  }

  public retrieveAudiofile(audiofileId) {
    this.audiofileService()
      .find(audiofileId)
      .then(res => {
        this.audiofile = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
