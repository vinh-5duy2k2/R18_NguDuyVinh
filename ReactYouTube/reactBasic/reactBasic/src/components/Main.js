import React, { Component } from "react";

export default class Main extends Component {
  constructor(props) {
    super(props);
    this.handleClick = this.handleClick.bind(this);
  }
  handleClick = (text) => {
    alert(`Buy ${text} Success`);
  };
  render() {
    return (
      <div>
        <div className="col-xs-3 col-md-3 col-sm-3 col-lg-3 col-xl-3">
          <div className="img-thumbnail">
            <img src={this.props.image} alt={this.props.id} width={"100%"} />
            <div className="figure-caption">
              <h5>Name: {this.props.children}</h5>
              <p>Price: {this.props.price} VND</p>
            </div>
          </div>
          <button
            type="button"
            className="btn btn-outline-success"
            onClick={() => {
              this.handleClick(this.props.children);
            }}
          >
            Mua Ngay
          </button>
        </div>
      </div>
    );
  }
}
