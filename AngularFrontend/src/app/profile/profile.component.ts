import { Component, OnInit } from '@angular/core';
import { DataService } from '../_services/data.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user;
  constructor( private dataService: DataService, private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    const userData = this.tokenStorageService.getUser();
    console.log('email', userData.email);
    this.dataService.getUser(userData.email).subscribe(
      data => {
          this.user = data;
      }
    );
  }

}
