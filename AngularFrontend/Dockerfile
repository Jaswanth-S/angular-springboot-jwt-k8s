#Dockerfile for AngularFrontend
#nginx:alphine images is pulled and angular is exposed by nginx server

FROM nginx:alpine
COPY default.conf /etc/nginx/conf.d/default.conf
COPY /dist/AngularFrontend/ /usr/share/nginx/html
