"use client"
import React, { useEffect, useState } from "react";

export default function Page() {
  const url = "http://localhost:3001/espectador";

  const [espectadorListaState, setEspectadorListState] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      const res = await fetch(url, {
        method: "GET",
      });
      const json = await res.json();
      setEspectadorListState(json);
    };

    fetchData();
  }, []);

  console.log("espectadorLista",espectadorListaState );
  const lista : React.ElementType[] = [];


  return lista;
}
