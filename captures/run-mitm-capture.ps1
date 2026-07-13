param(
    [string]$ListenHost = "0.0.0.0",
    [int]$ListenPort = 8080,
    [string]$CaptureName = "cold-boot"
)

$ErrorActionPreference = "Stop"

$base = Split-Path -Parent $MyInvocation.MyCommand.Path
$rawDir = Join-Path $base "raw"
$logDir = Join-Path $base "logs"
New-Item -ItemType Directory -Force -Path $rawDir, $logDir | Out-Null

$ts = Get-Date -Format "yyyyMMdd-HHmmss"
$flowFile = Join-Path $rawDir "$CaptureName-$ts.mitm"
$eventLog = Join-Path $logDir "$CaptureName-$ts-events.jsonl"

# Resolve mitmdump script installed by pip (Windows Store Python layout).
$py = "python"
$scriptPath = & $py -c "import pathlib,site; p=pathlib.Path(site.getuserbase())/'Python313'/'Scripts'/'mitmdump.exe'; print(p if p.exists() else '')"
if (-not $scriptPath) {
    $scriptPath = & $py -c "import pathlib,site; p=pathlib.Path(site.getuserbase())/'Python313'/'Scripts'/'mitmdump'; print(p if p.exists() else '')"
}
if (-not $scriptPath) {
    throw "mitmdump executable/script not found under user-site Scripts. Install mitmproxy with pip for the active Python."
}

Write-Host "Starting mitm capture"
Write-Host " flow file : $flowFile"
Write-Host " event log : $eventLog"
Write-Host " listen    : $ListenHost`:$ListenPort"
Write-Host ""
Write-Host "Next on emulator host:"
Write-Host " 1) Set LDPlayer proxy to this host:$ListenPort"
Write-Host " 2) Install mitmproxy CA from http://mitm.it"
Write-Host " 3) Cold boot app and reproduce failure point"
Write-Host " 4) Stop capture with Ctrl+C"

& $scriptPath --listen-host $ListenHost --listen-port $ListenPort -w $flowFile --set block_global=false --set flow_detail=3
