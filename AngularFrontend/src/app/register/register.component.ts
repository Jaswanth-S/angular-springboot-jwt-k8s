import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form: any = {
    email: '',
    password: '',
    // repeatpsw: '',
    name: ''
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  hideSuccessMessage = false;
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }
  // Implement onSubmit  to save the user details
  onSubmit() {
    // console.log("initial value",this.form);
    // if (this.form.password === this.form.repeatpsw ) {
    if (this.form.password.length >= 6 ) {
    //  this.form.role = "user";
    //  console.log("final value",this.form);
     this.authService.register(this.form).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
   }
  }
  FadeOutSuccessMsg() {
    setTimeout( () => {
        this.hideSuccessMessage = true;
     }, 2200);
}

}
