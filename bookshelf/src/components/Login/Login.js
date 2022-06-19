import React from 'react';
import api from "./api";
import { useNavigate } from "react-router-dom";


function Login() {
  const  [data_stats, setData] = React.useState([]);
  const [username, setUsername] = React.useState("");
  const [password, setPassword] = React.useState("");
  console.log("Username", username);
  console.log("Password", password);
  React.useEffect(() => {
    api.get('clients/Clients').then(res => {
    console.log("OIOIOIIOIOIIOIOIOIIOO", res);
    setData(res.data);
});
},[]);

let navigate = useNavigate(); 
const routeChange = () =>{ 
  let path = '/index'; 
  navigate(path);
}
  console.log(data_stats);

  return (
    <form>
      <div className="input-container">
        <label>Username </label>
        <input value={username} type="text" name="uname" onChange={event => setUsername(event.target.value)} required />
        { }
      </div>
      <div className="input-container">
        <label>Password </label>
        <input value={password} type="password" name="pass" onChange={event => setPassword(event.target.value)} required />
        { }
      </div>
      
      {username === data_stats[0]?.name && password === data_stats[0]?.password ?(

      <>
      <div >
        <button onClick={routeChange}>Login</button>
      </div>
      </>
      ) : (
        <div >
        <button >Login</button>
      </div>
      )}
    </form>

  )
}
export default Login;