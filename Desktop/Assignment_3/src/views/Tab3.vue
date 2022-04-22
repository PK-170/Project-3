<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Map</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <div id="map" ref="mapRef"></div>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
// @ts-nocheck
/* eslint-disable */

import { ref, onMounted } from "vue";
import { database, auth } from "../main";
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
} from "@ionic/vue";

export default {
  name: "Tab3",
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
  },
  setup() {
    const mapRef = ref(null);

    const addMap = async () => {
      const latLng = new google.maps.LatLng(-41.28664, 174.77557);

      const mapOptions = {
        center: latLng,
        zoom: 3,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
      };

      let map = new google.maps.Map(mapRef.value, mapOptions);

      const user = auth.currentUser;
      const snap = await database
        .collection("users")
        .doc(user?.uid)
        .collection("images")
        .get();

      if (!snap.empty) {
        snap.docs.forEach((doc) => {
          const data = doc.data();

          const imageLatLng = new google.maps.LatLng(
            data.location.lat,
            data.location.lon
          );

          const marker = new google.maps.Marker({
            position: imageLatLng,
          });

          marker.setMap(map);
        });
      }
    };

    onMounted(() => {
      addMap();
    });

    return {
      mapRef,
    };
  },
};
</script>

<style>
#map {
  width: 100%;
  height: 100%;
}
</style>