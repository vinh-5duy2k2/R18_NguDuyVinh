import React, { Component } from "react";
import "./App.css";
import Header from "./components/Header";
import Main from "./components/Main";

export default class App extends Component {
  constructor(props) {
    super(props);
    this.input = React.createRef();
  }
  handleSubmit = () => {
    console.log(this.input.current.value);
    alert("Submit Success!!");
  };
  render() {
    const products = [
      {
        id: 1,
        name: "Iphone 13 ",
        image:
          "https://media.doanhnghiepvn.vn/Images/Uploaded/Share/2021/09/15/iPhone-13-Pro-iPhone-13-Pro-Max-1.jpg",
        price: 35000000,
        status: true,
      },
      {
        id: 2,
        name: "Iphone 13 ProMAX ",
        image:
          "https://media.doanhnghiepvn.vn/Images/Uploaded/Share/2021/09/15/iPhone-13-Pro-iPhone-13-Pro-Max-1.jpg",
        price: 40000000,
        status: true,
      },
      {
        id: 3,
        name: "Ipad ",
        image:
          "https://cdn.tgdd.vn/Products/Images/522/238651/ipad-pro-2021-129-inch-silver-600x600.jpg",
        price: 12345678,
        status: true,
      },
      {
        id: 4,
        name: "Macbook ",
        image:
          "https://cdn.tgdd.vn/Products/Images/44/231244/macbook-air-m1-2020-gray-600x600.jpg",
        price: 55000000,
        status: true,
      },
    ];
    const elements = products.map((product, index) => {
      return (
        <Main key={product.id} price={product.price} image={product.image}>
          {product.name}
        </Main>
      );
    });
    return (
      <div>
        <Header />
        <div className="container">
          <div className="row">
            <div className="row">
              <div className="col-xs-12 col-md-12 col-sm-12 col-lg-12 col-xl-12">
                <div className="form-group">
                  <label>Username</label>
                  <input
                    type="text"
                    className="form-control"
                    aria-describedby="helpId"
                    placeholder="Enter your username"
                    ref={this.input}
                  />
                </div>
                <button
                  type="submit"
                  className="btn btn-success"
                  onClick={this.handleSubmit}
                >
                  Submit
                </button>
              </div>
            </div>
            <div className="col-xs-12 col-md-12 col-sm-12 col-lg-12 col-xl-12">
              {elements}
            </div>
          </div>
        </div>
      </div>
    );
  }
}
