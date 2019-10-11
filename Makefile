TEMPLATEDIR:=resources/leiningen/new/re_frame_native

all: resources/manifest.lst

resources/manifest.lst:
	(cd ${TEMPLATEDIR} && find . -type f | sed 's|\.\/||') > $@
