import React from 'react';
import './InitialBook.css';
import book1 from './book1_tqs.jpg';
function InitiaBook() {
    function sayHello() {
        alert('Johnny you hit me!');
    }


    return (
        <>
        <div className="dash">

            <div className="dashItem">
            
                <div><img src={book1} className="bookImage" alt="logo" /> </div>
                <div className="bookTitle">Red Queen</div>
                <div className="bookAuthor">Victoria Aveyard</div>
                <div className="bookPrice">16.0$</div>
                <div className="buttonT">
                <button className="button-32" onClick={sayHello}>Add to Basket</button>
                </div>
                
            </div>

            <div className="dashItem">
            
                <div><img src={book1} className="bookImage" alt="logo" /> </div>
                
                <div className="bookTitle">Red Queen</div>
                <div className="bookAuthor">Victoria Aveyard</div>
                <div className="bookPrice">16.0$</div>
                <div className="buttonT">
                <button className="button-32" onClick={sayHello}>Add to Basket</button>
                </div>
                
            </div>

             <div className="dashItem">
            
                <div><img src={book1} className="bookImage" alt="logo" /> </div>
                <div className="bookTitle">Red Queen</div>
                <div className="bookAuthor">Victoria Aveyard</div>
                <div className="bookPrice">16.0$</div>
                <div className="buttonT">
                <button className="button-32" onClick={sayHello}>Add to Basket</button>
                </div>
                
                
            </div>

            <div className="dashItem">
            
                <div><img src={book1} className="bookImage" alt="logo" /> </div>
                <div className="bookTitle">Red Queen</div>
                <div className="bookAuthor">Victoria Aveyard</div>
                <div className="bookPrice">16.0$</div>
                <div className="buttonT">
                <button className="button-32" onClick={sayHello}>Add to Basket</button>
                </div>
                
            </div>
            <div className="dashItem">
            
                <div><img src={book1} className="bookImage" alt="logo" /> </div>
                <div className="bookTitle">Red Queen</div>
                <div className="bookAuthor">Victoria Aveyard</div>
                <div className="bookPrice">16.0$</div>
                <div className="buttonT">
                <button className="button-32" onClick={sayHello}>Add to Basket</button>
                </div>
                
            </div>
    </div>
    <div className="dash2">

        <div className="dashItem">
        
            <div><img src={book1} className="bookImage" alt="logo" /> </div>
            <div className="bookTitle">Red Queen</div>
            <div className="bookAuthor">Victoria Aveyard</div>
            <div className="bookPrice">16.0$</div>
            <div className="buttonT">
            <button className="button-32" onClick={sayHello}>Add to Basket</button>
            </div>
            
        </div>

        <div className="dashItem">
        
            <div><img src={book1} className="bookImage" alt="logo" /> </div>
            
            <div className="bookTitle">Red Queen</div>
            <div className="bookAuthor">Victoria Aveyard</div>
            <div className="bookPrice">16.0$</div>
            <div className="buttonT">
            <button className="button-32" onClick={sayHello}>Add to Basket</button>
            </div>
            
        </div>

    <div className="dashItem">
        
            <div><img src={book1} className="bookImage" alt="logo" /> </div>
            <div className="bookTitle">Red Queen</div>
            <div className="bookAuthor">Victoria Aveyard</div>
            <div className="bookPrice">16.0$</div>
            <div className="buttonT">
            <button className="button-32" onClick={sayHello}>Add to Basket</button>
            </div>
            
            
        </div>

        <div className="dashItem">
        
            <div><img src={book1} className="bookImage" alt="logo" /> </div>
            <div className="bookTitle">Red Queen</div>
            <div className="bookAuthor">Victoria Aveyard</div>
            <div className="bookPrice">16.0$</div>
            <div className="buttonT">
            <button className="button-32" onClick={sayHello}>Add to Basket</button>
            </div>
            
        </div>
        <div className="dashItem">
        
            <div><img src={book1} className="bookImage" alt="logo" /> </div>
            <div className="bookTitle">Red Queen</div>
            <div className="bookAuthor">Victoria Aveyard</div>
            <div className="bookPrice">16.0$</div>
            <div className="buttonT">
            <button className="button-32" onClick={sayHello}>Add to Basket</button>
            </div>
            
        </div>
    </div>
</>
    
    )
    
}

export default InitiaBook;