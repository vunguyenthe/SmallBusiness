import React, { Component } from 'react';
import './App.css';
import SockJsClient from 'react-stomp';

class App extends Component {
	  constructor(props) {
		super(props);
		  this.state = {
			data: 'no data'
		  };		
	  }
    
     handleData(msg) {
	  console.log(msg);
     // let result = JSON.parse(msg);
	 // console.log('msg: ' + msg);
     // this.setState({count: this.state.count + 1});
	 this.setState({data: msg.message});
    }
	
	  sendMessage = (msg) => {
		this.clientRef.sendMessage('/topic/messages', msg);
	  }
	  
	render() {
	return (
	  <div>
	    Message: <strong>{this.state.data}</strong>
		<SockJsClient url='http://178.62.13.26:9090/chat' topics={['/topic/messages']}
			onMessage={this.handleData.bind(this)}
			ref={ (client) => { this.clientRef = client }} />
	  </div>
	);
  }
}

export default App;
