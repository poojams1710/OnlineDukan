import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { GetUserService} from '../../get-user.service';

@Component({
  selector: 'app-user-type',
  templateUrl: './user-type.component.html',
  styleUrls: ['./user-type.component.css']
})
export class UserTypeComponent implements OnInit {

  users :Array<User>
  action :string;
  UserKind :User

  constructor(private getservice : GetUserService,
    private router :Router,
    private activatedRoute :ActivatedRoute) { }

  ngOnInit(): void {
    this.getservice.getUserType().subscribe((data)=>{
      this.users = data ;
    })


    this.activatedRoute.queryParams.subscribe((params) =>{
      this.action = params['action']
    })
  }


  addUser(){

    this.UserKind = new User();
    this.router.navigate(['admin','users'] ,{queryParams :{action:'add'}})
  }
}
