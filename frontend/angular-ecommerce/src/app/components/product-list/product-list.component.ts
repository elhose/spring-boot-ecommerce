import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/common/product';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];
  currentCategoryId: number;

  constructor(private productService: ProductService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listProducts()
    });
  }

  listProducts() {

    // check if "id" parameter is avalivable
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');

    if (hasCategoryId) {
      // get current "id" parameter
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id');
    } else {
      // if it isn't avalivable then set it to 1 -> products
      this.currentCategoryId = 1;
    }

    this.productService.getProductList(this.currentCategoryId).subscribe(
      data => {
        this.products = data;
      }
    );
  }

}
