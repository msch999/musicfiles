<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="musicfilesApp.device.home.createOrEditLabel"
          data-cy="DeviceCreateUpdateHeading"
          v-text="$t('musicfilesApp.device.home.createOrEditLabel')"
        >
          Create or edit a Device
        </h2>
        <div>
          <div class="form-group" v-if="device.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="device.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('musicfilesApp.device.name')" for="device-name">Name</label>
            <input
              type="text"
              class="form-control"
              name="name"
              id="device-name"
              data-cy="name"
              :class="{ valid: !$v.device.name.$invalid, invalid: $v.device.name.$invalid }"
              v-model="$v.device.name.$model"
              required
            />
            <div v-if="$v.device.name.$anyDirty && $v.device.name.$invalid">
              <small class="form-text text-danger" v-if="!$v.device.name.required" v-text="$t('entity.validation.required')">
                This field is required.
              </small>
            </div>
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
            :disabled="$v.device.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./device-update.component.ts"></script>
