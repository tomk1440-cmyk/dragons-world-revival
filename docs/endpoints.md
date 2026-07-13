# Dragons World endpoint map (initial, from static APK analysis)

## Priority bootstrap/config surface

Extracted from Unity data blob:
- `client-analysis/apktool/assets/bin/Data/96b9bb33d58e825409ae13b6dde5defe`
- normalized copy: `client-analysis/bootstrap-config.json`

The client contains a bootstrap-style config object with:
- `currentConnection: "mzoo_int_prod"`
- `connections` map (environment name -> URL)
- `requestTimeout`, `bundleRequestTimeout`, `resourceLoader`, `guildChat`

This is likely the first gate before gameplay (white-screen failures are very likely tied to this path).

## Known backend/status endpoints

| Method | URL | Role (inferred) | Source |
|---|---|---|---|
| GET | `http://dragons-int.socialquantum.com/mzoo_int_prod/status` | default bootstrap/status endpoint (`currentConnection`) | `bootstrap-config.json` |
| GET | `http://dragons-int.socialquantum.com/mzoo_kakao_prod/status` | Kakao production status | `bootstrap-config.json` |
| GET | `http://dragons-ru.socialquantum.com/mzoo_beta/status` | RU beta status | `bootstrap-config.json` |
| GET | `http://web76.socialquantum.com/mzoo_alpha_*/status` | alpha/test status endpoints (multiple variants) | `bootstrap-config.json` |
| GET | `http://web76.socialquantum.com/mzoo_alpha_web_*/status` | web alpha variants | `bootstrap-config.json` |
| GET | `http://localhost:3000/status` | local dev status | `bootstrap-config.json` |
| GET | `https://localhost/status` | local secure status | `bootstrap-config.json` |
| GET | `http://10.0.1.x:3000/status` and `http://192.168.x.x:3000/status` | internal/dev status endpoints | `bootstrap-config.json` |

## Other discovered hosts

| Host | Purpose (inferred) | Source |
|---|---|---|
| `web21.socialquantum.com:9933` | guild chat backend (`guildChat.host` / `port`) | `bootstrap-config.json` |
| `mobiledev.socialquantum.com` | CDN/static promo assets (`mobile_assets_west3d/...png`) | `assets/bin/Data/b574d3c6d1257b24ba69344dec96d841` |
| `10.0.1.86:1221` | asset base URL in internal config (`baseUrl`) | `bootstrap-config.json` |

## Response shape notes (inferred)

No live responses captured yet, but the embedded bootstrap config indicates expected fields include:
- `currentConnection` (string)
- `connections` (object of named env URLs)
- `requestTimeout` / `bundleRequestTimeout` (number)
- `resourceLoader` (string, e.g. `CDN`)
- `guildChat` object (`host`, `port`, `zone`)

This should be the first format to emulate when stubbing.
