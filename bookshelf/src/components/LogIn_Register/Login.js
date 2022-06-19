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

  function validateForm() {

    return email.length > 0 && password.length > 0;

  }

  function handleSubmit(event) {

    event.preventDefault();

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

                type="email"

                value={email}

                onChange={(e) => setEmail(e.target.value)}
                placeholder="User Name"

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

            <Button  className="button-4" block size="lg" type="submit" disabled={!validateForm()}>

            Login

            </Button>

            </Form>
            <div className="signintext" onClick={handleClick}>Register Now</div>

        </div>

     

    </div>

  );

}