/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import AudiofileDetailComponent from '@/entities/audiofile/audiofile-details.vue';
import AudiofileClass from '@/entities/audiofile/audiofile-details.component';
import AudiofileService from '@/entities/audiofile/audiofile.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Audiofile Management Detail Component', () => {
    let wrapper: Wrapper<AudiofileClass>;
    let comp: AudiofileClass;
    let audiofileServiceStub: SinonStubbedInstance<AudiofileService>;

    beforeEach(() => {
      audiofileServiceStub = sinon.createStubInstance<AudiofileService>(AudiofileService);

      wrapper = shallowMount<AudiofileClass>(AudiofileDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { audiofileService: () => audiofileServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundAudiofile = { id: 123 };
        audiofileServiceStub.find.resolves(foundAudiofile);

        // WHEN
        comp.retrieveAudiofile(123);
        await comp.$nextTick();

        // THEN
        expect(comp.audiofile).toBe(foundAudiofile);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundAudiofile = { id: 123 };
        audiofileServiceStub.find.resolves(foundAudiofile);

        // WHEN
        comp.beforeRouteEnter({ params: { audiofileId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.audiofile).toBe(foundAudiofile);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
