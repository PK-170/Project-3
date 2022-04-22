import { createApp } from 'vue'
import App from './App.vue'
import router from './router';
import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';
import 'firebase/compat/firestore';
import 'firebase/compat/storage';

import { IonicVue } from '@ionic/vue';
import {defineCustomElements} from '@ionic/pwa-elements/loader';

/* Core CSS required for Ionic components to work properly */
import '@ionic/vue/css/core.css';

/* Basic CSS for apps built with Ionic */
import '@ionic/vue/css/normalize.css';
import '@ionic/vue/css/structure.css';
import '@ionic/vue/css/typography.css';

/* Optional CSS utils that can be commented out */
import '@ionic/vue/css/padding.css';
import '@ionic/vue/css/float-elements.css';
import '@ionic/vue/css/text-alignment.css';
import '@ionic/vue/css/text-transformation.css';
import '@ionic/vue/css/flex-utils.css';
import '@ionic/vue/css/display.css';

/* Theme variables */
import './theme/variables.css';

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyCx4SF9FD78Iudx8JydjFUpd-RLKLPumo8",
  authDomain: "assignment-3-7ee60.firebaseapp.com",
  projectId: "assignment-3-7ee60",
  storageBucket: "assignment-3-7ee60.appspot.com",
  messagingSenderId: "594503605637",
  appId: "1:594503605637:web:38b736ad802f85437338ec"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);

defineCustomElements(window);
export const auth = firebase.auth();
export const database = firebase.firestore();
export const storage = firebase.storage();

let app: any;

auth.onAuthStateChanged(async user => {
  if (!app) {
    app = createApp(App)
      .use(IonicVue)
      .use(router);

    router.isReady().then(() => {
      app.mount('#app');
    });
  }
})
