<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>My App</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-card>
        <ion-card-header>
          <ion-card-title> Welcome to my Ionic app </ion-card-title>
          <ion-card-subtitle> Please Sign In/ Sign Up </ion-card-subtitle>
        </ion-card-header>
        <ion-card-content>
          <form
            @submit.prevent="
              mode === AuthMode.SignIn
                ? signInWithEmailAndPassword(email, password)
                : signUpWithEmailAndPassword(name, email, password)
            "
          >
            <ion-item v-if="mode === AuthMode.SignUp">
              <ion-label position="floating">Name</ion-label>
              <ion-input v-model="name"></ion-input>
            </ion-item>
            <ion-item>
              <ion-label position="floating">Email</ion-label>
              <ion-input v-model="email"></ion-input>
            </ion-item>
            <ion-item>
              <ion-label position="floating">Password</ion-label>
              <ion-input v-model="password" type="password"></ion-input>
            </ion-item>
            <ion-button
              expand="block"
              color="success"
              class="ion-margin-top"
              type="submit"
            >
              {{ mode === AuthMode.SignIn ? "Sign In" : "Sign Up" }}
            </ion-button>
            <ion-button
              expand="block"
              color="dark"
              class="ion-margin-top"
              @click="
                mode =
                  mode === AuthMode.SignIn ? AuthMode.SignUp : AuthMode.SignIn
              "
            >
              {{ mode === AuthMode.SignIn ? "Sign Up" : "Cancel" }}
            </ion-button>
          </form>
        </ion-card-content>
        <ion-card-content v-if="errorMsg" class="error-message">
          {{ errorMsg }}
        </ion-card-content>
      </ion-card>
    </ion-content>
  </ion-page>
</template>


<script lang="ts">
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonCard,
  IonCardSubtitle,
  IonCardTitle,
  IonCardContent,
  IonInput,
  IonButton,
  IonLabel,
  IonItem,
} from "@ionic/vue";

import { auth, database } from "../main";
import { reactive, toRefs } from "vue";
import { useRouter } from "vue-router";
import { async } from "@firebase/util";

enum AuthMode {
  SignIn,
  SignUp,
}

export default {
  name: "Authenication",
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
    IonContent,
    IonCard,
    IonCardSubtitle,
    IonCardTitle,
    IonCardContent,
    IonInput,
    IonLabel,
    IonItem,
    IonTitle,
    IonButton,
  },
  setup() {
    const router = useRouter();
    const state = reactive({
      name: "",
      email: "",
      password: "",
      mode: AuthMode.SignIn,
      errorMsg: "",
    });

    const signInWithEmailAndPassword = async (
      email: string,
      password: string
    ) => {
      try {
        if (!email || !password) {
          state.errorMsg = "email and password must be entered";
          return;
        }

        await auth.signInWithEmailAndPassword(email, password);
        router.push("/tabs/tab1");
      } catch (e) {
        console.log((e as Error).message);
      }
    };

    const signUpWithEmailAndPassword = async (
      name: string,
      email: string,
      password: string
    ) => {
      try {
        if (!name || !email || !password) {
          state.errorMsg = "Name, email, and password required!";
          return;
        }

        const authRes = await auth.createUserWithEmailAndPassword(
          email,
          password
        );

        database.collection("users").doc(authRes.user?.uid).set({
          name,
          email,
        });

        router.push("/tabs/tab1");
      } catch (e) {
        console.log((e as Error).message);
      }
    };

    return {
      ...toRefs(state),
      signInWithEmailAndPassword,
      signUpWithEmailAndPassword,
      AuthMode,
    };
  },
};
</script>

<style>
.center {
  display: flex;
  height: 90vh;
  width: 90%;
  align-items: center;
  justify-content: center;
}
.error-message {
  color: #842029;
  background-color: #f8d7da;
  border-color: #f5c2c7;
  text-align: center;
}
</style>