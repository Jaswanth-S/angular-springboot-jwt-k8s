import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }
     // Implement the onSubmit method once user clicks on login button
  // Write logic so that on successful login, store the user details in session
  onSubmit() {
    this.authService.login(this.form).subscribe(
      data => {
        // console.log('token',data.token);
        this.tokenStorage.saveToken(data.token);
        this.tokenStorage.saveUser(this.form);

        this.isLoginFailed = false;
        this.isLoggedIn = true;

        this.reloadPage();
      },
      err => {
        this.isLoginFailed = true;
        this.errorMessage = err.error.message;
      }
    );
  }

  reloadPage() {
    window.location.reload();
  }
}
