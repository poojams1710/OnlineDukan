import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetUserService } from 'src/app/shopservice/get-user.service';
import { Shops } from 'src/app/model/shops';

@Component({
  selector: 'app-addshop',
  templateUrl: './addshop.component.html',
  styleUrls: ['./addshop.component.css']
})
export class AddshopComponent implements OnInit {

  @Input()
  shop :Shops;

  private selectedFile;
  imgURL: any;

  constructor(private getservice : GetUserService,
    private httpClient :HttpClient,private router :Router
    ) { }

  ngOnInit(): void {
  }





  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };

  }



  saveshop() {

    const uploadData = new FormData();
    uploadData.append('imageFile', this.selectedFile, this.selectedFile.name);
    this.selectedFile.imageName = this.selectedFile.name;

    this.httpClient.post('http://localhost:9090/shops/upload', uploadData, { observe: 'response' })
      .subscribe((response) => {
        if (response.status === 200) {
          this.getservice.addshop(this.shop).subscribe(
            (shops) => {
              this.router.navigate(['admin', 'shops']);
            }
          );
          console.log('Image uploaded successfully');
        } else {
          console.log('Image not uploaded successfully');
        }
      }
      );
  }


}
