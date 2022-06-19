import React, { useState } from "react";

import Form from "react-bootstrap/Form";
import { useNavigate } from 'react-router-dom';

import Button from "react-bootstrap/Button";

import "./Login.css";

export default function Login() {
    const navigate = useNavigate();

  function handleClick(){
    navigate("/register")
  }

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [isSubmited, setIsSubmitted] = useState("");


  function validateForm() {

    return email.length > 0 && password.length > 0;

  }

  function handleSubmit(event) {

    event.preventDefault();
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json',  'Access-Control-Allow-Origin': '*'},
      body: JSON.stringify({username: email, password: password})
    };

    
    
    fetch(`http://localhost:8080/api/auth/authenticate`, requestOptions)
    .then(response => response.json())
    .then(data => { 
        if (data.error){
          setIsSubmitted(false);
        }
        if (data.token){
            localStorage.setItem("info", JSON.stringify(data));
            setIsSubmitted(true);
            navigate("/inicialDash")
        }
    });

  }

  return (

    <div className="Login">
        <div className="card">
            <div className="Signup">Sign In</div>
            
            
            <Form onSubmit={handleSubmit}>

            <Form.Group size="lg" controlId="email">

            {/* <Form.Label className="">User Name: </Form.Label> */}

            <Form.Control className="forms"

                autoFocus

                type="name"

                value={email}

                onChange={(e) => setEmail(e.target.value)}
                placeholder="Username"

            />

            </Form.Group>

            <Form.Group size="lg" controlId="password">

            {/* <Form.Label>Password</Form.Label> */}

            <Form.Control className="forms"

                type="password"

                value={password}

                onChange={(e) => setPassword(e.target.value)}
                placeholder="Password"

            />

            </Form.Group>
            {
                isSubmited===false ?
                <div className="signintext">Login Error</div>
                :
                <></>
              }

            <Button  className="button-4" block size="lg" type="submit" disabled={!validateForm()}>

            Login

            </Button>

            </Form>
              <Button className="button-3" onClick={handleClick} block variant="secondary">Register Now</Button>
              
        </div>


    </div>

  );

}