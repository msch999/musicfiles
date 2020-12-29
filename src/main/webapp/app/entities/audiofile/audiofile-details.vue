<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="audiofile">
        <h2 class="jh-entity-heading" data-cy="audiofileDetailsHeading">
          <span v-text="$t('musicfilesApp.audiofile.detail.title')">Audiofile</span> {{ audiofile.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.artist')">Artist</span>
          </dt>
          <dd>
            <span>{{ audiofile.artist }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.album')">Album</span>
          </dt>
          <dd>
            <span>{{ audiofile.album }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.comment')">Comment</span>
          </dt>
          <dd>
            <span>{{ audiofile.comment }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.genre')">Genre</span>
          </dt>
          <dd>
            <span>{{ audiofile.genre }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.title')">Title</span>
          </dt>
          <dd>
            <span>{{ audiofile.title }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.track')">Track</span>
          </dt>
          <dd>
            <span>{{ audiofile.track }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.total')">Total</span>
          </dt>
          <dd>
            <span>{{ audiofile.total }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.year')">Year</span>
          </dt>
          <dd>
            <span>{{ audiofile.year }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.fieldname')">Fieldname</span>
          </dt>
          <dd>
            <span>{{ audiofile.fieldname }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.bitrate')">Bitrate</span>
          </dt>
          <dd>
            <span>{{ audiofile.bitrate }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.bitspersample')">Bitspersample</span>
          </dt>
          <dd>
            <span>{{ audiofile.bitspersample }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.codec')">Codec</span>
          </dt>
          <dd>
            <span>{{ audiofile.codec }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.covermimetype')">Covermimetype</span>
          </dt>
          <dd>
            <span>{{ audiofile.covermimetype }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.coversize')">Coversize</span>
          </dt>
          <dd>
            <span>{{ audiofile.coversize }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.covertype')">Covertype</span>
          </dt>
          <dd>
            <span>{{ audiofile.covertype }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.coverheight')">Coverheight</span>
          </dt>
          <dd>
            <span>{{ audiofile.coverheight }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.coverwidth')">Coverwidth</span>
          </dt>
          <dd>
            <span>{{ audiofile.coverwidth }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.covers')">Covers</span>
          </dt>
          <dd>
            <span>{{ audiofile.covers }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.lengthseconds')">Lengthseconds</span>
          </dt>
          <dd>
            <span>{{ audiofile.lengthseconds }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.mode')">Mode</span>
          </dt>
          <dd>
            <span>{{ audiofile.mode }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.samplerate')">Samplerate</span>
          </dt>
          <dd>
            <span>{{ audiofile.samplerate }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.tool')">Tool</span>
          </dt>
          <dd>
            <span>{{ audiofile.tool }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.vbr')">Vbr</span>
          </dt>
          <dd>
            <span>{{ audiofile.vbr }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.directory')">Directory</span>
          </dt>
          <dd>
            <span>{{ audiofile.directory }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.extension')">Extension</span>
          </dt>
          <dd>
            <span>{{ audiofile.extension }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.filename')">Filename</span>
          </dt>
          <dd>
            <span>{{ audiofile.filename }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.filenameext')">Filenameext</span>
          </dt>
          <dd>
            <span>{{ audiofile.filenameext }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.filenamerel')">Filenamerel</span>
          </dt>
          <dd>
            <span>{{ audiofile.filenamerel }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.folderpath')">Folderpath</span>
          </dt>
          <dd>
            <span>{{ audiofile.folderpath }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.folderpathrel')">Folderpathrel</span>
          </dt>
          <dd>
            <span>{{ audiofile.folderpathrel }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.parentdirectory')">Parentdirectory</span>
          </dt>
          <dd>
            <span>{{ audiofile.parentdirectory }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.path')">Path</span>
          </dt>
          <dd>
            <span>{{ audiofile.path }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.volume')">Volume</span>
          </dt>
          <dd>
            <span>{{ audiofile.volume }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.workingdir')">Workingdir</span>
          </dt>
          <dd>
            <span>{{ audiofile.workingdir }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.workingpath')">Workingpath</span>
          </dt>
          <dd>
            <span>{{ audiofile.workingpath }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.filecreatedate')">Filecreatedate</span>
          </dt>
          <dd>
            <span>{{ audiofile.filecreatedate }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.filemoddate')">Filemoddate</span>
          </dt>
          <dd>
            <span>{{ audiofile.filemoddate }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.filesizebytes')">Filesizebytes</span>
          </dt>
          <dd>
            <span>{{ audiofile.filesizebytes }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.crcVal')">Crc Val</span>
          </dt>
          <dd>
            <span>{{ audiofile.crcVal }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.md5Val')">Md 5 Val</span>
          </dt>
          <dd>
            <span>{{ audiofile.md5Val }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.md5audioVal')">Md 5 Audio Val</span>
          </dt>
          <dd>
            <span>{{ audiofile.md5audioVal }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.appVal')">App Val</span>
          </dt>
          <dd>
            <span>{{ audiofile.appVal }}</span>
          </dd>
          <dt>
            <span v-text="$t('musicfilesApp.audiofile.device')">Device</span>
          </dt>
          <dd>
            <div v-if="audiofile.device">
              <router-link :to="{ name: 'DeviceView', params: { deviceId: audiofile.device.id } }">{{ audiofile.device.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="audiofile.id"
          :to="{ name: 'AudiofileEdit', params: { audiofileId: audiofile.id } }"
          tag="button"
          class="btn btn-primary"
        >
          <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./audiofile-details.component.ts"></script>
