/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import DeviceComponent from '@/entities/device/device.vue';
import DeviceClass from '@/entities/device/device.component';
import DeviceService from '@/entities/device/device.service';

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
  describe('Device Management Component', () => {
    let wrapper: Wrapper<DeviceClass>;
    let comp: DeviceClass;
    let deviceServiceStub: SinonStubbedInstance<DeviceService>;

    beforeEach(() => {
      deviceServiceStub = sinon.createStubInstance<DeviceService>(DeviceService);
      deviceServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<DeviceClass>(DeviceComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          deviceService: () => deviceServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      deviceServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllDevices();
      await comp.$nextTick();

      // THEN
      expect(deviceServiceStub.retrieve.called).toBeTruthy();
      expect(comp.devices[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      deviceServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeDevice();
      await comp.$nextTick();

      // THEN
      expect(deviceServiceStub.delete.called).toBeTruthy();
      expect(deviceServiceStub.retrieve.callCount).toEqual(1);
    });
  });
});
