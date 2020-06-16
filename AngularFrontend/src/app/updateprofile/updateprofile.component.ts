import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
import { DataService } from '../_services/data.service';

@Component({
  selector: 'app-updateprofile',
  templateUrl: './updateprofile.component.html',
  styleUrls: ['./updateprofile.component.css']
})
export class UpdateprofileComponent implements OnInit {
  user = {
    email : '',
    name : '',
    age : ''
  };
  message = '';
  isUpdated;
  constructor( private tokenStorage: TokenStorageService, private dataService: DataService) { }

  ngOnInit() {
    this.user = this.tokenStorage.getUser();
  }

  updateUser(user) {
    this.dataService.updateUser(user).subscribe(
        data => {
          this.isUpdated = true;
          this.message = 'Updated Profile Successfully!!!';
        },
        err => {
          this.isUpdated = true;
          this.message = 'Failed to update Profile!!!';
        }
    );
  }
}
