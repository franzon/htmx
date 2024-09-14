@import dev.franzon.habittracker.dto.HabitoDeHojeDTO

@param HabitoDeHojeDTO habitoDeHoje

<div class="border rounded-lg p-4 flex flex-row ${!habitoDeHoje.isPronto() ? "bg-gray-950 border-slate-950" : "border-gray-500"}"
     id="habito-de-hoje-${habitoDeHoje.getId()}">
    <span class="flex-grow ${habitoDeHoje.isPronto() ? "line-through": "font-bold"}">${habitoDeHoje.getTitulo()}</span>
    <input type="checkbox" checked="${habitoDeHoje.isPronto()}" class="checkbox"
           hx-post="/habitos-de-hoje/click/${habitoDeHoje.getId()}" hx-target="#habito-de-hoje-${habitoDeHoje.getId()}"
           hx-swap="outerHTML"/>
</div>