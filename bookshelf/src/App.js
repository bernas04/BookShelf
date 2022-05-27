import './App.css';
import {Route, Routes} from "react-router";
import InitialDash from './InitialDash';
import Cart from './components/Cart/Cart';


function App() {

  return (
    <Routes>
      <Route path="/" element={<InitialDash />} />
      <Route path="/basket" element={<Cart />} />
    </Routes>
    
  );
}

export default App;
