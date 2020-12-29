/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';

import AudiofileService from '@/entities/audiofile/audiofile.service';
import { Audiofile } from '@/shared/model/audiofile.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('Audiofile Service', () => {
    let service: AudiofileService;
    let elemDefault;

    beforeEach(() => {
      service = new AudiofileService();
      elemDefault = new Audiofile(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign({}, elemDefault);
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should create a Audiofile', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a Audiofile', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a Audiofile', async () => {
        const returnedFromService = Object.assign(
          {
            artist: 'BBBBBB',
            album: 'BBBBBB',
            comment: 'BBBBBB',
            genre: 'BBBBBB',
            title: 'BBBBBB',
            track: 'BBBBBB',
            total: 'BBBBBB',
            year: 'BBBBBB',
            fieldname: 'BBBBBB',
            bitrate: 'BBBBBB',
            bitspersample: 'BBBBBB',
            codec: 'BBBBBB',
            covermimetype: 'BBBBBB',
            coversize: 'BBBBBB',
            covertype: 'BBBBBB',
            coverheight: 'BBBBBB',
            coverwidth: 'BBBBBB',
            covers: 'BBBBBB',
            lengthseconds: 'BBBBBB',
            mode: 'BBBBBB',
            samplerate: 'BBBBBB',
            tool: 'BBBBBB',
            vbr: 'BBBBBB',
            directory: 'BBBBBB',
            extension: 'BBBBBB',
            filename: 'BBBBBB',
            filenameext: 'BBBBBB',
            filenamerel: 'BBBBBB',
            folderpath: 'BBBBBB',
            folderpathrel: 'BBBBBB',
            parentdirectory: 'BBBBBB',
            path: 'BBBBBB',
            volume: 'BBBBBB',
            workingdir: 'BBBBBB',
            workingpath: 'BBBBBB',
            filecreatedate: 'BBBBBB',
            filemoddate: 'BBBBBB',
            filesizebytes: 'BBBBBB',
            crcVal: 'BBBBBB',
            md5Val: 'BBBBBB',
            md5audioVal: 'BBBBBB',
            appVal: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a Audiofile', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of Audiofile', async () => {
        const returnedFromService = Object.assign(
          {
            artist: 'BBBBBB',
            album: 'BBBBBB',
            comment: 'BBBBBB',
            genre: 'BBBBBB',
            title: 'BBBBBB',
            track: 'BBBBBB',
            total: 'BBBBBB',
            year: 'BBBBBB',
            fieldname: 'BBBBBB',
            bitrate: 'BBBBBB',
            bitspersample: 'BBBBBB',
            codec: 'BBBBBB',
            covermimetype: 'BBBBBB',
            coversize: 'BBBBBB',
            covertype: 'BBBBBB',
            coverheight: 'BBBBBB',
            coverwidth: 'BBBBBB',
            covers: 'BBBBBB',
            lengthseconds: 'BBBBBB',
            mode: 'BBBBBB',
            samplerate: 'BBBBBB',
            tool: 'BBBBBB',
            vbr: 'BBBBBB',
            directory: 'BBBBBB',
            extension: 'BBBBBB',
            filename: 'BBBBBB',
            filenameext: 'BBBBBB',
            filenamerel: 'BBBBBB',
            folderpath: 'BBBBBB',
            folderpathrel: 'BBBBBB',
            parentdirectory: 'BBBBBB',
            path: 'BBBBBB',
            volume: 'BBBBBB',
            workingdir: 'BBBBBB',
            workingpath: 'BBBBBB',
            filecreatedate: 'BBBBBB',
            filemoddate: 'BBBBBB',
            filesizebytes: 'BBBBBB',
            crcVal: 'BBBBBB',
            md5Val: 'BBBBBB',
            md5audioVal: 'BBBBBB',
            appVal: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of Audiofile', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a Audiofile', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a Audiofile', async () => {
        axiosStub.delete.rejects(error);

        return service
          .delete(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
