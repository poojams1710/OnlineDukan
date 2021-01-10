import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetUserService } from '../get-user.service';
import { ShopProducts } from '../model/ShopProducts';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {


  product : ShopProducts = new ShopProducts();
  private selectedFile;
  imgURL: any;


  constructor(private uploadproducts: GetUserService,
     private httpClient: HttpClient,
      router: Router) { }

  ngOnInit(): void {
  };




  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };
  }







  saveproduct() {

    const uploadData = new FormData();
    uploadData.append('imageFile', this.selectedFile, this.selectedFile.name);
    this.selectedFile.imageName = this.selectedFile.name;

    this.httpClient.post('http://localhost:9090/products/upload', uploadData, { observe: 'response' })
      .subscribe((response) => {
        if (response.status === 200) {
          this.uploadproducts.addproduct(this.product).subscribe(
            (product) => {
              this.product = new ShopProducts();
              console.log("uploaded");
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


