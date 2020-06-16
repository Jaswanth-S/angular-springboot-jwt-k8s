import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  token;
  isLoggedIn ;
  showUserBoard;
  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    //  check token is available or not
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      // const user = this.tokenStorageService.getUser();
      // console.log("user", user);

      this.token = this.tokenStorageService.getToken();
      // console.log('token', this.token);
      const jwt = this.token;
      const jwtData = jwt.split('.')[1];
      const decodedJwtJsonData = window.atob(jwtData);
      // console.log('decodedJwtJsonData: ' + decodedJwtJsonData);
      const data = JSON.parse(decodedJwtJsonData);
      const role = Object.values(data)[1];
      this.showUserBoard = true;
    }
  }

  // Implement logout method when user clicks logout and clear the session storage
  logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
  }


