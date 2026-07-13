## Repository setup status

- Local project structure created:
  - `client-analysis/`
  - `captures/` (`raw/`, `annotated/`, `logs/`)
  - `server/`
  - `docs/`
- `gh` CLI installed locally at `tools/gh/bin/gh.exe`.
- Attempted command:
  - `gh repo create dragons-world-revival --private --source=. --remote=origin`
- Current blocker:
  - GitHub CLI is not authenticated in this environment (`gh auth login` or `GH_TOKEN` required).

## Reverse-engineering progress

- APK acquired and stored as `client-analysis/com.sq.dragonsworld.apk`.
- Decompiled using apktool + jadx into `client-analysis/apktool/` and `client-analysis/jadx/`.
- Bootstrap/config extracted to `client-analysis/bootstrap-config.json`.
- Endpoint/host mapping documented in:
  - `docs/endpoints.md`
  - `docs/hosts-endpoints.csv`

## Step 2 capture readiness

- Capture folders are prepared.
- Helper script added:
  - `captures/run-mitm-capture.ps1`
- To run on emulator host:
  - `.\captures\run-mitm-capture.ps1`
  - configure LDPlayer proxy to host:8080
  - install mitmproxy CA cert in emulator trusted store
