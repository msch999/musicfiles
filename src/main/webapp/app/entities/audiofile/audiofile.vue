<template>
  <div>
    <h2 id="page-heading" data-cy="AudiofileHeading">
      <span v-text="$t('musicfilesApp.audiofile.home.title')" id="audiofile-heading">Audiofiles</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('userManagement.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link
          :to="{ name: 'AudiofileCreate' }"
          tag="button"
          id="jh-create-entity"
          data-cy="entityCreateButton"
          class="btn btn-primary jh-create-entity create-audiofile"
        >
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('musicfilesApp.audiofile.home.createLabel')"> Create a new Audiofile </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && audiofiles && audiofiles.length === 0">
      <span v-text="$t('musicfilesApp.audiofile.home.notFound')">No audiofiles found</span>
    </div>
    <div class="table-responsive" v-if="audiofiles && audiofiles.length > 0">
      <table class="table table-striped" aria-describedby="audiofiles">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.artist')">Artist</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.album')">Album</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.comment')">Comment</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.genre')">Genre</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.title')">Title</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.track')">Track</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.total')">Total</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.year')">Year</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.fieldname')">Fieldname</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.bitrate')">Bitrate</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.bitspersample')">Bitspersample</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.codec')">Codec</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.covermimetype')">Covermimetype</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.coversize')">Coversize</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.covertype')">Covertype</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.coverheight')">Coverheight</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.coverwidth')">Coverwidth</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.covers')">Covers</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.lengthseconds')">Lengthseconds</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.mode')">Mode</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.samplerate')">Samplerate</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.tool')">Tool</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.vbr')">Vbr</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.directory')">Directory</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.extension')">Extension</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.filename')">Filename</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.filenameext')">Filenameext</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.filenamerel')">Filenamerel</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.folderpath')">Folderpath</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.folderpathrel')">Folderpathrel</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.parentdirectory')">Parentdirectory</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.path')">Path</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.volume')">Volume</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.workingdir')">Workingdir</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.workingpath')">Workingpath</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.filecreatedate')">Filecreatedate</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.filemoddate')">Filemoddate</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.filesizebytes')">Filesizebytes</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.crcVal')">Crc Val</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.md5Val')">Md 5 Val</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.md5audioVal')">Md 5 Audio Val</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.appVal')">App Val</span></th>
            <th scope="row"><span v-text="$t('musicfilesApp.audiofile.device')">Device</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="audiofile in audiofiles" :key="audiofile.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'AudiofileView', params: { audiofileId: audiofile.id } }">{{ audiofile.id }}</router-link>
            </td>
            <td>{{ audiofile.artist }}</td>
            <td>{{ audiofile.album }}</td>
            <td>{{ audiofile.comment }}</td>
            <td>{{ audiofile.genre }}</td>
            <td>{{ audiofile.title }}</td>
            <td>{{ audiofile.track }}</td>
            <td>{{ audiofile.total }}</td>
            <td>{{ audiofile.year }}</td>
            <td>{{ audiofile.fieldname }}</td>
            <td>{{ audiofile.bitrate }}</td>
            <td>{{ audiofile.bitspersample }}</td>
            <td>{{ audiofile.codec }}</td>
            <td>{{ audiofile.covermimetype }}</td>
            <td>{{ audiofile.coversize }}</td>
            <td>{{ audiofile.covertype }}</td>
            <td>{{ audiofile.coverheight }}</td>
            <td>{{ audiofile.coverwidth }}</td>
            <td>{{ audiofile.covers }}</td>
            <td>{{ audiofile.lengthseconds }}</td>
            <td>{{ audiofile.mode }}</td>
            <td>{{ audiofile.samplerate }}</td>
            <td>{{ audiofile.tool }}</td>
            <td>{{ audiofile.vbr }}</td>
            <td>{{ audiofile.directory }}</td>
            <td>{{ audiofile.extension }}</td>
            <td>{{ audiofile.filename }}</td>
            <td>{{ audiofile.filenameext }}</td>
            <td>{{ audiofile.filenamerel }}</td>
            <td>{{ audiofile.folderpath }}</td>
            <td>{{ audiofile.folderpathrel }}</td>
            <td>{{ audiofile.parentdirectory }}</td>
            <td>{{ audiofile.path }}</td>
            <td>{{ audiofile.volume }}</td>
            <td>{{ audiofile.workingdir }}</td>
            <td>{{ audiofile.workingpath }}</td>
            <td>{{ audiofile.filecreatedate }}</td>
            <td>{{ audiofile.filemoddate }}</td>
            <td>{{ audiofile.filesizebytes }}</td>
            <td>{{ audiofile.crcVal }}</td>
            <td>{{ audiofile.md5Val }}</td>
            <td>{{ audiofile.md5audioVal }}</td>
            <td>{{ audiofile.appVal }}</td>
            <td>
              <div v-if="audiofile.device">
                <router-link :to="{ name: 'DeviceView', params: { deviceId: audiofile.device.id } }">{{ audiofile.device.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'AudiofileView', params: { audiofileId: audiofile.id } }"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
                <router-link
                  :to="{ name: 'AudiofileEdit', params: { audiofileId: audiofile.id } }"
                  tag="button"
                  class="btn btn-primary btn-sm edit"
                  data-cy="entityEditButton"
                >
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(audiofile)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="musicfilesApp.audiofile.delete.question" data-cy="audiofileDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-audiofile-heading" v-text="$t('musicfilesApp.audiofile.delete.question', { id: removeId })">
          Are you sure you want to delete this Audiofile?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-audiofile"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeAudiofile()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./audiofile.component.ts"></script>
