# rama-clj-template

Sets up repl with hot reloading.

Uses [mount](https://github.com/tolitius/mount) to hot reload.

## Usage

`lein repl`, then `(reset)` to reload code.

Alternatively, can use `M-x` `cider-jack-in` from Emacs.

## Notes
`lein` (and `deps.edn`) automatically load the namespace `user` and the profile `:dev`. `user` is in `dev/user.clj`.
