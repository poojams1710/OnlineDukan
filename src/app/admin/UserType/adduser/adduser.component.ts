import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { User } from 'src/app/model/user';
import {GetUserService} from 'src/app/get-user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  @Input()
  user: User

  // @Output()
  //  addedUser = new EventEmitter() ;


   newUser : User ;
   type: String;
   password :String;
   message :String

  constructor(private addservice : GetUserService ,
    private router :Router) { }

  ngOnInit(): void {
    this.newUser = Object.assign({}, this.user);


  }

  addUser(){
    this.addservice.addUser(this.user).subscribe((user) =>{
      // this.addedUser.emit();
      this.router.navigate(['admin','users'])
    })
  }
}
