"use client"
import React, { useEffect, useState } from "react";

export default function Page() {
  const url = "http://localhost:3001/espectador";

  const [espectadorListaState, setEspectadorListState] = useState<any[]>([]);

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

  const lista = espectadorListaState.map(e => (
    <li key={e.id}>
      <div>Nome: {e.nome}</div>
      <div>Ativo: {e.ativo ? 'Sim' : 'Não'}</div>
      <div>Email: {e.email}</div>
    </li>
  ));


  return <ul>{lista}</ul>;
}
