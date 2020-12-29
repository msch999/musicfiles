<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="musicfilesApp.audiofile.home.createOrEditLabel"
          data-cy="AudiofileCreateUpdateHeading"
          v-text="$t('musicfilesApp.audiofile.home.createOrEditLabel')"
        >
          Create or edit a Audiofile
        </h2>
        <div>
          <div class="form-group" v-if="audiofile.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="audiofile.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.artist')" for="audiofile-artist">Artist</label>
            <input
              type="text"
              class="form-control"
              name="artist"
              id="audiofile-artist"
              data-cy="artist"
              :class="{ valid: !$v.audiofile.artist.$invalid, invalid: $v.audiofile.artist.$invalid }"
              v-model="$v.audiofile.artist.$model"
              required
            />
            <div v-if="$v.audiofile.artist.$anyDirty && $v.audiofile.artist.$invalid">
              <small class="form-text text-danger" v-if="!$v.audiofile.artist.required" v-text="$t('entity.validation.required')">
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.album')" for="audiofile-album">Album</label>
            <input
              type="text"
              class="form-control"
              name="album"
              id="audiofile-album"
              data-cy="album"
              :class="{ valid: !$v.audiofile.album.$invalid, invalid: $v.audiofile.album.$invalid }"
              v-model="$v.audiofile.album.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.comment')" for="audiofile-comment">Comment</label>
            <input
              type="text"
              class="form-control"
              name="comment"
              id="audiofile-comment"
              data-cy="comment"
              :class="{ valid: !$v.audiofile.comment.$invalid, invalid: $v.audiofile.comment.$invalid }"
              v-model="$v.audiofile.comment.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.genre')" for="audiofile-genre">Genre</label>
            <input
              type="text"
              class="form-control"
              name="genre"
              id="audiofile-genre"
              data-cy="genre"
              :class="{ valid: !$v.audiofile.genre.$invalid, invalid: $v.audiofile.genre.$invalid }"
              v-model="$v.audiofile.genre.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.title')" for="audiofile-title">Title</label>
            <input
              type="text"
              class="form-control"
              name="title"
              id="audiofile-title"
              data-cy="title"
              :class="{ valid: !$v.audiofile.title.$invalid, invalid: $v.audiofile.title.$invalid }"
              v-model="$v.audiofile.title.$model"
              required
            />
            <div v-if="$v.audiofile.title.$anyDirty && $v.audiofile.title.$invalid">
              <small class="form-text text-danger" v-if="!$v.audiofile.title.required" v-text="$t('entity.validation.required')">
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.track')" for="audiofile-track">Track</label>
            <input
              type="text"
              class="form-control"
              name="track"
              id="audiofile-track"
              data-cy="track"
              :class="{ valid: !$v.audiofile.track.$invalid, invalid: $v.audiofile.track.$invalid }"
              v-model="$v.audiofile.track.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.total')" for="audiofile-total">Total</label>
            <input
              type="text"
              class="form-control"
              name="total"
              id="audiofile-total"
              data-cy="total"
              :class="{ valid: !$v.audiofile.total.$invalid, invalid: $v.audiofile.total.$invalid }"
              v-model="$v.audiofile.total.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.year')" for="audiofile-year">Year</label>
            <input
              type="text"
              class="form-control"
              name="year"
              id="audiofile-year"
              data-cy="year"
              :class="{ valid: !$v.audiofile.year.$invalid, invalid: $v.audiofile.year.$invalid }"
              v-model="$v.audiofile.year.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.fieldname')" for="audiofile-fieldname">Fieldname</label>
            <input
              type="text"
              class="form-control"
              name="fieldname"
              id="audiofile-fieldname"
              data-cy="fieldname"
              :class="{ valid: !$v.audiofile.fieldname.$invalid, invalid: $v.audiofile.fieldname.$invalid }"
              v-model="$v.audiofile.fieldname.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.bitrate')" for="audiofile-bitrate">Bitrate</label>
            <input
              type="text"
              class="form-control"
              name="bitrate"
              id="audiofile-bitrate"
              data-cy="bitrate"
              :class="{ valid: !$v.audiofile.bitrate.$invalid, invalid: $v.audiofile.bitrate.$invalid }"
              v-model="$v.audiofile.bitrate.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.bitspersample')" for="audiofile-bitspersample"
              >Bitspersample</label
            >
            <input
              type="text"
              class="form-control"
              name="bitspersample"
              id="audiofile-bitspersample"
              data-cy="bitspersample"
              :class="{ valid: !$v.audiofile.bitspersample.$invalid, invalid: $v.audiofile.bitspersample.$invalid }"
              v-model="$v.audiofile.bitspersample.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.codec')" for="audiofile-codec">Codec</label>
            <input
              type="text"
              class="form-control"
              name="codec"
              id="audiofile-codec"
              data-cy="codec"
              :class="{ valid: !$v.audiofile.codec.$invalid, invalid: $v.audiofile.codec.$invalid }"
              v-model="$v.audiofile.codec.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.covermimetype')" for="audiofile-covermimetype"
              >Covermimetype</label
            >
            <input
              type="text"
              class="form-control"
              name="covermimetype"
              id="audiofile-covermimetype"
              data-cy="covermimetype"
              :class="{ valid: !$v.audiofile.covermimetype.$invalid, invalid: $v.audiofile.covermimetype.$invalid }"
              v-model="$v.audiofile.covermimetype.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.coversize')" for="audiofile-coversize">Coversize</label>
            <input
              type="text"
              class="form-control"
              name="coversize"
              id="audiofile-coversize"
              data-cy="coversize"
              :class="{ valid: !$v.audiofile.coversize.$invalid, invalid: $v.audiofile.coversize.$invalid }"
              v-model="$v.audiofile.coversize.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.covertype')" for="audiofile-covertype">Covertype</label>
            <input
              type="text"
              class="form-control"
              name="covertype"
              id="audiofile-covertype"
              data-cy="covertype"
              :class="{ valid: !$v.audiofile.covertype.$invalid, invalid: $v.audiofile.covertype.$invalid }"
              v-model="$v.audiofile.covertype.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.coverheight')" for="audiofile-coverheight"
              >Coverheight</label
            >
            <input
              type="text"
              class="form-control"
              name="coverheight"
              id="audiofile-coverheight"
              data-cy="coverheight"
              :class="{ valid: !$v.audiofile.coverheight.$invalid, invalid: $v.audiofile.coverheight.$invalid }"
              v-model="$v.audiofile.coverheight.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.coverwidth')" for="audiofile-coverwidth"
              >Coverwidth</label
            >
            <input
              type="text"
              class="form-control"
              name="coverwidth"
              id="audiofile-coverwidth"
              data-cy="coverwidth"
              :class="{ valid: !$v.audiofile.coverwidth.$invalid, invalid: $v.audiofile.coverwidth.$invalid }"
              v-model="$v.audiofile.coverwidth.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.covers')" for="audiofile-covers">Covers</label>
            <input
              type="text"
              class="form-control"
              name="covers"
              id="audiofile-covers"
              data-cy="covers"
              :class="{ valid: !$v.audiofile.covers.$invalid, invalid: $v.audiofile.covers.$invalid }"
              v-model="$v.audiofile.covers.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.lengthseconds')" for="audiofile-lengthseconds"
              >Lengthseconds</label
            >
            <input
              type="text"
              class="form-control"
              name="lengthseconds"
              id="audiofile-lengthseconds"
              data-cy="lengthseconds"
              :class="{ valid: !$v.audiofile.lengthseconds.$invalid, invalid: $v.audiofile.lengthseconds.$invalid }"
              v-model="$v.audiofile.lengthseconds.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.mode')" for="audiofile-mode">Mode</label>
            <input
              type="text"
              class="form-control"
              name="mode"
              id="audiofile-mode"
              data-cy="mode"
              :class="{ valid: !$v.audiofile.mode.$invalid, invalid: $v.audiofile.mode.$invalid }"
              v-model="$v.audiofile.mode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.samplerate')" for="audiofile-samplerate"
              >Samplerate</label
            >
            <input
              type="text"
              class="form-control"
              name="samplerate"
              id="audiofile-samplerate"
              data-cy="samplerate"
              :class="{ valid: !$v.audiofile.samplerate.$invalid, invalid: $v.audiofile.samplerate.$invalid }"
              v-model="$v.audiofile.samplerate.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.tool')" for="audiofile-tool">Tool</label>
            <input
              type="text"
              class="form-control"
              name="tool"
              id="audiofile-tool"
              data-cy="tool"
              :class="{ valid: !$v.audiofile.tool.$invalid, invalid: $v.audiofile.tool.$invalid }"
              v-model="$v.audiofile.tool.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.vbr')" for="audiofile-vbr">Vbr</label>
            <input
              type="text"
              class="form-control"
              name="vbr"
              id="audiofile-vbr"
              data-cy="vbr"
              :class="{ valid: !$v.audiofile.vbr.$invalid, invalid: $v.audiofile.vbr.$invalid }"
              v-model="$v.audiofile.vbr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.directory')" for="audiofile-directory">Directory</label>
            <input
              type="text"
              class="form-control"
              name="directory"
              id="audiofile-directory"
              data-cy="directory"
              :class="{ valid: !$v.audiofile.directory.$invalid, invalid: $v.audiofile.directory.$invalid }"
              v-model="$v.audiofile.directory.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.extension')" for="audiofile-extension">Extension</label>
            <input
              type="text"
              class="form-control"
              name="extension"
              id="audiofile-extension"
              data-cy="extension"
              :class="{ valid: !$v.audiofile.extension.$invalid, invalid: $v.audiofile.extension.$invalid }"
              v-model="$v.audiofile.extension.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.filename')" for="audiofile-filename">Filename</label>
            <input
              type="text"
              class="form-control"
              name="filename"
              id="audiofile-filename"
              data-cy="filename"
              :class="{ valid: !$v.audiofile.filename.$invalid, invalid: $v.audiofile.filename.$invalid }"
              v-model="$v.audiofile.filename.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.filenameext')" for="audiofile-filenameext"
              >Filenameext</label
            >
            <input
              type="text"
              class="form-control"
              name="filenameext"
              id="audiofile-filenameext"
              data-cy="filenameext"
              :class="{ valid: !$v.audiofile.filenameext.$invalid, invalid: $v.audiofile.filenameext.$invalid }"
              v-model="$v.audiofile.filenameext.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.filenamerel')" for="audiofile-filenamerel"
              >Filenamerel</label
            >
            <input
              type="text"
              class="form-control"
              name="filenamerel"
              id="audiofile-filenamerel"
              data-cy="filenamerel"
              :class="{ valid: !$v.audiofile.filenamerel.$invalid, invalid: $v.audiofile.filenamerel.$invalid }"
              v-model="$v.audiofile.filenamerel.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.folderpath')" for="audiofile-folderpath"
              >Folderpath</label
            >
            <input
              type="text"
              class="form-control"
              name="folderpath"
              id="audiofile-folderpath"
              data-cy="folderpath"
              :class="{ valid: !$v.audiofile.folderpath.$invalid, invalid: $v.audiofile.folderpath.$invalid }"
              v-model="$v.audiofile.folderpath.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.folderpathrel')" for="audiofile-folderpathrel"
              >Folderpathrel</label
            >
            <input
              type="text"
              class="form-control"
              name="folderpathrel"
              id="audiofile-folderpathrel"
              data-cy="folderpathrel"
              :class="{ valid: !$v.audiofile.folderpathrel.$invalid, invalid: $v.audiofile.folderpathrel.$invalid }"
              v-model="$v.audiofile.folderpathrel.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.parentdirectory')" for="audiofile-parentdirectory"
              >Parentdirectory</label
            >
            <input
              type="text"
              class="form-control"
              name="parentdirectory"
              id="audiofile-parentdirectory"
              data-cy="parentdirectory"
              :class="{ valid: !$v.audiofile.parentdirectory.$invalid, invalid: $v.audiofile.parentdirectory.$invalid }"
              v-model="$v.audiofile.parentdirectory.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.path')" for="audiofile-path">Path</label>
            <input
              type="text"
              class="form-control"
              name="path"
              id="audiofile-path"
              data-cy="path"
              :class="{ valid: !$v.audiofile.path.$invalid, invalid: $v.audiofile.path.$invalid }"
              v-model="$v.audiofile.path.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.volume')" for="audiofile-volume">Volume</label>
            <input
              type="text"
              class="form-control"
              name="volume"
              id="audiofile-volume"
              data-cy="volume"
              :class="{ valid: !$v.audiofile.volume.$invalid, invalid: $v.audiofile.volume.$invalid }"
              v-model="$v.audiofile.volume.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.workingdir')" for="audiofile-workingdir"
              >Workingdir</label
            >
            <input
              type="text"
              class="form-control"
              name="workingdir"
              id="audiofile-workingdir"
              data-cy="workingdir"
              :class="{ valid: !$v.audiofile.workingdir.$invalid, invalid: $v.audiofile.workingdir.$invalid }"
              v-model="$v.audiofile.workingdir.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.workingpath')" for="audiofile-workingpath"
              >Workingpath</label
            >
            <input
              type="text"
              class="form-control"
              name="workingpath"
              id="audiofile-workingpath"
              data-cy="workingpath"
              :class="{ valid: !$v.audiofile.workingpath.$invalid, invalid: $v.audiofile.workingpath.$invalid }"
              v-model="$v.audiofile.workingpath.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.filecreatedate')" for="audiofile-filecreatedate"
              >Filecreatedate</label
            >
            <input
              type="text"
              class="form-control"
              name="filecreatedate"
              id="audiofile-filecreatedate"
              data-cy="filecreatedate"
              :class="{ valid: !$v.audiofile.filecreatedate.$invalid, invalid: $v.audiofile.filecreatedate.$invalid }"
              v-model="$v.audiofile.filecreatedate.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.filemoddate')" for="audiofile-filemoddate"
              >Filemoddate</label
            >
            <input
              type="text"
              class="form-control"
              name="filemoddate"
              id="audiofile-filemoddate"
              data-cy="filemoddate"
              :class="{ valid: !$v.audiofile.filemoddate.$invalid, invalid: $v.audiofile.filemoddate.$invalid }"
              v-model="$v.audiofile.filemoddate.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.filesizebytes')" for="audiofile-filesizebytes"
              >Filesizebytes</label
            >
            <input
              type="text"
              class="form-control"
              name="filesizebytes"
              id="audiofile-filesizebytes"
              data-cy="filesizebytes"
              :class="{ valid: !$v.audiofile.filesizebytes.$invalid, invalid: $v.audiofile.filesizebytes.$invalid }"
              v-model="$v.audiofile.filesizebytes.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.crcVal')" for="audiofile-crcVal">Crc Val</label>
            <input
              type="text"
              class="form-control"
              name="crcVal"
              id="audiofile-crcVal"
              data-cy="crcVal"
              :class="{ valid: !$v.audiofile.crcVal.$invalid, invalid: $v.audiofile.crcVal.$invalid }"
              v-model="$v.audiofile.crcVal.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.md5Val')" for="audiofile-md5Val">Md 5 Val</label>
            <input
              type="text"
              class="form-control"
              name="md5Val"
              id="audiofile-md5Val"
              data-cy="md5Val"
              :class="{ valid: !$v.audiofile.md5Val.$invalid, invalid: $v.audiofile.md5Val.$invalid }"
              v-model="$v.audiofile.md5Val.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.md5audioVal')" for="audiofile-md5audioVal"
              >Md 5 Audio Val</label
            >
            <input
              type="text"
              class="form-control"
              name="md5audioVal"
              id="audiofile-md5audioVal"
              data-cy="md5audioVal"
              :class="{ valid: !$v.audiofile.md5audioVal.$invalid, invalid: $v.audiofile.md5audioVal.$invalid }"
              v-model="$v.audiofile.md5audioVal.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.appVal')" for="audiofile-appVal">App Val</label>
            <input
              type="text"
              class="form-control"
              name="appVal"
              id="audiofile-appVal"
              data-cy="appVal"
              :class="{ valid: !$v.audiofile.appVal.$invalid, invalid: $v.audiofile.appVal.$invalid }"
              v-model="$v.audiofile.appVal.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.audiofile.device')" for="audiofile-device">Device</label>
            <select class="form-control" id="audiofile-device" data-cy="device" name="device" v-model="audiofile.device">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="audiofile.device && deviceOption.id === audiofile.device.id ? audiofile.device : deviceOption"
                v-for="deviceOption in devices"
                :key="deviceOption.id"
              >
                {{ deviceOption.id }}
              </option>
            </select>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.audiofile.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./audiofile-update.component.ts"></script>
