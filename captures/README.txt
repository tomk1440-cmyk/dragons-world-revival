Step 2 capture status: pending runtime capture.

Why pending:
- This environment does not have LDPlayer/Android emulator access.
- `mitmproxy` is not installed here.

When running locally with emulator:
1. Start mitmproxy and save flow file:
   `mitmproxy -w captures\cold-boot.mitm`
2. Configure emulator proxy to host:8080.
3. Install mitmproxy CA cert in emulator trusted store.
4. Cold boot app and capture until failure point.
5. Export annotated HTTP pairs to:
   - `captures\raw\`
   - `captures\annotated\`

Capture priorities:
- First bootstrap/config call
- First auth call
- Any CDN/bootstrap asset fetches
- Failed/timeout requests (keep them; failure point is useful)
