import { IAudiofile } from '@/shared/model/audiofile.model';

export interface IDevice {
  id?: number;
  name?: string;
  audiofiles?: IAudiofile[];
}

export class Device implements IDevice {
  constructor(public id?: number, public name?: string, public audiofiles?: IAudiofile[]) {}
}
