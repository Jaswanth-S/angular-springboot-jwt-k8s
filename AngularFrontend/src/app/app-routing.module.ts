import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UpdateprofileComponent } from './updateprofile/updateprofile.component';
import { AuthguardService } from './_services/authguard.service';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {path: 'profile', component: ProfileComponent, canActivate: [AuthguardService] },
  {path: 'updateprofile', component: UpdateprofileComponent, canActivate: [AuthguardService] },
  { path: '', redirectTo: 'login', pathMatch: 'full' }

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
