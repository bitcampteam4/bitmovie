import React, {useEffect, useState} from 'react';
import './Location.css';
import axios from "axios";
const Location = (props) => {
    const [mloc,setMloc] = useState([]);
    const {input,setInput,changeData}=props;

    const get=()=>{
        axios.get('http://localhost:8282/theater/')
            .then((response) =>{
                setMloc(response.data);

            });
    }

    useEffect(()=>{

        get();

    },[]);


    return (
        <div>
            {mloc.map((list,i)=>(
                <ul key={i}>
                    <li style={{listStyle:'none'}}>
                <button key={i} value={JSON.stringify(list)} style={{fontSize:'15px'}} className={'lcbtn'} name={'location'} onClick={changeData}>{list.the_name}</button>
                    </li>
                </ul>
            ))}
        </div>
    );
};

export default Location;