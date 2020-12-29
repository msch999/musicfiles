import { IDevice } from '@/shared/model/device.model';

export interface IAudiofile {
  id?: number;
  artist?: string;
  album?: string;
  comment?: string;
  genre?: string;
  title?: string;
  track?: string;
  total?: string;
  year?: string;
  fieldname?: string;
  bitrate?: string;
  bitspersample?: string;
  codec?: string;
  covermimetype?: string;
  coversize?: string;
  covertype?: string;
  coverheight?: string;
  coverwidth?: string;
  covers?: string;
  lengthseconds?: string;
  mode?: string;
  samplerate?: string;
  tool?: string;
  vbr?: string;
  directory?: string;
  extension?: string;
  filename?: string;
  filenameext?: string;
  filenamerel?: string;
  folderpath?: string;
  folderpathrel?: string;
  parentdirectory?: string;
  path?: string;
  volume?: string;
  workingdir?: string;
  workingpath?: string;
  filecreatedate?: string;
  filemoddate?: string;
  filesizebytes?: string;
  crcVal?: string;
  md5Val?: string;
  md5audioVal?: string;
  appVal?: string;
  device?: IDevice;
}

export class Audiofile implements IAudiofile {
  constructor(
    public id?: number,
    public artist?: string,
    public album?: string,
    public comment?: string,
    public genre?: string,
    public title?: string,
    public track?: string,
    public total?: string,
    public year?: string,
    public fieldname?: string,
    public bitrate?: string,
    public bitspersample?: string,
    public codec?: string,
    public covermimetype?: string,
    public coversize?: string,
    public covertype?: string,
    public coverheight?: string,
    public coverwidth?: string,
    public covers?: string,
    public lengthseconds?: string,
    public mode?: string,
    public samplerate?: string,
    public tool?: string,
    public vbr?: string,
    public directory?: string,
    public extension?: string,
    public filename?: string,
    public filenameext?: string,
    public filenamerel?: string,
    public folderpath?: string,
    public folderpathrel?: string,
    public parentdirectory?: string,
    public path?: string,
    public volume?: string,
    public workingdir?: string,
    public workingpath?: string,
    public filecreatedate?: string,
    public filemoddate?: string,
    public filesizebytes?: string,
    public crcVal?: string,
    public md5Val?: string,
    public md5audioVal?: string,
    public appVal?: string,
    public device?: IDevice
  ) {}
}
