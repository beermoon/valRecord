const $ = (s)=>document.querySelector(s);

$("#loginBtn").onclick = async ()=>{
    const r = await fetch("/auth/login", {
        method:"POST",
        headers:{ "Content-Type":"application/x-www-form-urlencoded" },
        body: new URLSearchParams({ email: $("#email").value, password: $("#pw").value })
    });
    const data = await r.json();
    if(data.ok){
        const me = await fetch("/auth/me").then(r=>r.json());
        $("#me").textContent = `userId=${me.userId} / puuid=${me.puuid}`;
        $("#matches").style.display = "block";
        loadMatches();
    }
};

async function loadMatches(){
    const list = await fetch("/api/me/matches?size=5").then(r=>r.json());
    const wrap = document.querySelector("#list");
    wrap.innerHTML = "";
    list.forEach(x=>{
        const div = document.createElement("div");
        div.className = "card";
        div.innerHTML = `
      <div class="row">
        <div><strong>${x.map}</strong> <span class="tag">${x.queue}</span></div>
        <div class="${x.result==='WIN'?'win':'lose'}">${x.result}</div>
      </div>
      <div class="row">
        <div>에이전트: ${x.agent}</div>
        <div>${new Date(x.startedAt).toLocaleString()}</div>
      </div>
      <button onclick="detail('${x.matchId}')">상세</button>
    `;
        wrap.appendChild(div);
    });
}

async function detail(id){
    const d = await fetch(`/api/matches/${id}`).then(r=>r.json());
    alert(`[${d.map}] ${d.queue} - ${d.result}\nKDA: ${d.my.k}/${d.my.d}/${d.my.a} | ACS: ${d.my.acs}`);
}