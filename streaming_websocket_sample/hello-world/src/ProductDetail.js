/* eslint-disable no-unused-vars*/
import React from 'react';
import './index.css';
import logo from './logo.svg';
import Websocket from 'react-websocket';
  
class ProductDetail extends React.Component {
 
    constructor(props) {
      super(props);
      this.state = {
        count: 90
      };
    }
 
    handleData(data) {
      let result = JSON.parse(data);
      this.setState({count: this.state.count + result.movement});
    }
 
    render() {
		alert('render');
      return (
        <div>
          Count: <strong>{this.state.count}</strong>
 
          <Websocket url='http://localhost:9090/chat'
              onMessage={this.handleData.bind(this)}/>
        </div>
      );
    }
  }
 
  export default ProductDetail;
