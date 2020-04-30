import React, { useState, useEffect } from 'react';
import Skeleton from '@material-ui/lab/Skeleton';
export default function Fetcher(props) {
    const { url } = props;
    let [clicks, setClicks] = useState(0);
    const [response, setResponse] = useState(null);

    useEffect( ()=> {
      const  fetchData= async()=>{
        const res = await fetch(url);
        const json = await res.json();
        setResponse(null)
        setTimeout(function () {
          setResponse(json);
        }, 1000);
      }
      fetchData();
    }, [url, clicks]);

    const doSomething = function (event) {
        console.log(event.currentTarget.getAttribute('data-something'));
    }
    return (
        <React.Fragment>
            <p>{response? JSON.stringify(response) :
              <p>
                <Skeleton animation="wave" />
                <Skeleton variant="text"/>
                <Skeleton variant="text"/>
                <Skeleton variant="circle" width={40} height={40}/>
                <Skeleton variant="rect" width={210} height={118}/>
              </p>
            }</p>
        </React.Fragment>
    );
}
