import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  authenticate(username, password) {
    if (username === "root" && password === "root") {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    return user !== null;
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
