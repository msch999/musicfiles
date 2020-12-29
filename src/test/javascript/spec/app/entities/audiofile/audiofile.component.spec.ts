/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import AudiofileComponent from '@/entities/audiofile/audiofile.vue';
import AudiofileClass from '@/entities/audiofile/audiofile.component';
import AudiofileService from '@/entities/audiofile/audiofile.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Audiofile Management Component', () => {
    let wrapper: Wrapper<AudiofileClass>;
    let comp: AudiofileClass;
    let audiofileServiceStub: SinonStubbedInstance<AudiofileService>;

    beforeEach(() => {
      audiofileServiceStub = sinon.createStubInstance<AudiofileService>(AudiofileService);
      audiofileServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<AudiofileClass>(AudiofileComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          audiofileService: () => audiofileServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      audiofileServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllAudiofiles();
      await comp.$nextTick();

      // THEN
      expect(audiofileServiceStub.retrieve.called).toBeTruthy();
      expect(comp.audiofiles[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      audiofileServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeAudiofile();
      await comp.$nextTick();

      // THEN
      expect(audiofileServiceStub.delete.called).toBeTruthy();
      expect(audiofileServiceStub.retrieve.callCount).toEqual(1);
    });
  });
});
