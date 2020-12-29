import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const Audiofile = () => import('@/entities/audiofile/audiofile.vue');
// prettier-ignore
const AudiofileUpdate = () => import('@/entities/audiofile/audiofile-update.vue');
// prettier-ignore
const AudiofileDetails = () => import('@/entities/audiofile/audiofile-details.vue');
// prettier-ignore
const Device = () => import('@/entities/device/device.vue');
// prettier-ignore
const DeviceUpdate = () => import('@/entities/device/device-update.vue');
// prettier-ignore
const DeviceDetails = () => import('@/entities/device/device-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/audiofile',
    name: 'Audiofile',
    component: Audiofile,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/audiofile/new',
    name: 'AudiofileCreate',
    component: AudiofileUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/audiofile/:audiofileId/edit',
    name: 'AudiofileEdit',
    component: AudiofileUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/audiofile/:audiofileId/view',
    name: 'AudiofileView',
    component: AudiofileDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/device',
    name: 'Device',
    component: Device,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/device/new',
    name: 'DeviceCreate',
    component: DeviceUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/device/:deviceId/edit',
    name: 'DeviceEdit',
    component: DeviceUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/device/:deviceId/view',
    name: 'DeviceView',
    component: DeviceDetails,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
