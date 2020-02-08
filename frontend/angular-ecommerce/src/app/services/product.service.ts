import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ProductCategory } from '../common/product-category';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseURL = 'http://localhost:8080/api/products';
  private categoryURL = 'http://localhost:8080/api/product-category';

  constructor(private httpClient: HttpClient) { }

  getProductList(categoryId: number): Observable<Product[]> {

    // @TODO: need to build URL based on category ID and call it
    const searchURL = `${this.baseURL}/search/findByCategoryId?id=${categoryId}`;

    return this.getProducts(searchURL);
  }

  private getProducts(url: string): Observable<Product[]> {
    return this.httpClient.get<GetResponseProducts>(url).pipe(map(response => response._embedded.products));
  }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.httpClient.get<GetResponseProductCategory>(this.categoryURL).pipe(
      map(response => response._embedded.productCategory)
    );
  }

  searchProducts(theKeyword: string): Observable<Product[]> {
    const searchByKeyword = `${this.baseURL}/search/findByNameContaining?name=${theKeyword}`;

    return this.getProducts(searchByKeyword);
  }
}

interface GetResponseProducts {
  _embedded: {
    products: Product[]
  };
}

interface GetResponseProductCategory {
  _embedded: {
    productCategory: ProductCategory[]
  };
}

